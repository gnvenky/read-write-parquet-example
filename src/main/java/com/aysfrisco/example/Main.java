package com.aysfrisco.example;

// Generic Avro dependencies

import org.apache.avro.Schema;

import com.google.common.collect.Lists;
import org.apache.avro.reflect.ReflectData;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.parquet.avro.AvroParquetReader;
import org.apache.parquet.avro.AvroParquetWriter;
import org.apache.parquet.filter2.compat.FilterCompat;
import org.apache.parquet.filter2.predicate.FilterPredicate;
import org.apache.parquet.hadoop.ParquetReader;
import org.apache.parquet.hadoop.ParquetWriter;
import org.apache.parquet.io.api.Binary;

import java.util.Collection;

import org.apache.avro.generic.GenericRecord;
import static org.apache.parquet.filter2.predicate.FilterApi.binaryColumn;
import static org.apache.parquet.filter2.predicate.FilterApi.eq;
import static org.apache.parquet.hadoop.ParquetFileWriter.Mode.OVERWRITE;
import org.apache.log4j.BasicConfigurator;

// Hadoop stuff

// Generic Parquet dependencies
import org.apache.parquet.schema.MessageType;
import org.apache.parquet.hadoop.metadata.CompressionCodecName;

// Avro->Parquet dependencies
import org.apache.parquet.avro.AvroSchemaConverter;

public final class Main {
    public static void main(String[] args) throws Exception {

        Collection<Pojo> data = Lists.newArrayList(
                new Pojo(1, "airport"),
                new Pojo(2, "penguin"),
                new Pojo(3, "verb")
        );

        Configuration conf = new Configuration();
        Path dataFile = new Path("data.gz.parquet");

        // Write Pojos to a Parquet file
        try (ParquetWriter<Pojo> writer = AvroParquetWriter.<Pojo>builder(dataFile)
                .withSchema(ReflectData.AllowNull.get().getSchema(Pojo.class)) // generate nullable fields
                .withDataModel(ReflectData.get())
                .withConf(conf)
                .withCompressionCodec(CompressionCodecName.GZIP)
                .withWriteMode(OVERWRITE)
                .build()) {

            for (Pojo pojo : data) {
                writer.write(pojo);
            }
        }

        // Read Pojos from a Parquet file
        try (ParquetReader<Pojo> reader = AvroParquetReader.<Pojo>builder(dataFile)
                .withDataModel(new ReflectData(Pojo.class.getClassLoader()))
                .disableCompatibility() // always use this (since this is a new project)
                .withConf(conf)
                .build()) {

            Pojo pojo;
            while ((pojo = reader.read()) != null) {
                System.err.println("All records: " + pojo);
            }
        }

        // Read Pojos, but filter down to just Penguins
        FilterPredicate predicate = eq(binaryColumn("data"), Binary.fromString("penguin"));

        try (ParquetReader<Pojo> reader = AvroParquetReader.<Pojo>builder(dataFile)
                .withDataModel(new ReflectData(Pojo.class.getClassLoader()))
                .disableCompatibility() // always use this (since this is a new project)
                .withFilter(FilterCompat.get(predicate))
                .withConf(conf)
                .build()) {

            Pojo pojo;
            while ((pojo = reader.read()) != null) {
                System.err.println("Just Penguins: " + pojo);
            }
        }

        Schema avroSchema = UserRank.getClassSchema();
        MessageType parquetSchema = new AvroSchemaConverter().convert(avroSchema);

        UserRank dataToWrite[] = new UserRank[]{
                new UserRank(1, 3),
                new UserRank(2, 0),
                new UserRank(3, 100)
        };

        Path filePath = new Path("./example.parquet");
        int blockSize = 1024;
        int pageSize = 65535;
        try (
                AvroParquetWriter parquetWriter = new AvroParquetWriter(
                        filePath,
                        avroSchema,
                        CompressionCodecName.SNAPPY,
                        blockSize,
                        pageSize)
        ) {
            for (UserRank obj : dataToWrite) {
                parquetWriter.write(obj);
            }
        } catch (java.io.IOException e) {
            System.out.println(String.format("Error writing parquet file %s", e.getMessage()));
            e.printStackTrace();
        }

        try (
                ParquetReader reader = AvroParquetReader.<GenericRecord>builder(filePath).build();
        ) {
            Object obj = reader.read();

            while (obj != null) {
                if (obj instanceof GenericRecord) {
                    System.out.println((UserRank) obj);
                }
                obj = reader.read();
            }

        } catch (java.io.IOException e) {
            System.out.println(String.format("Error writing parquet file %s", e.getMessage()));
            e.printStackTrace();
        }
    }
}
