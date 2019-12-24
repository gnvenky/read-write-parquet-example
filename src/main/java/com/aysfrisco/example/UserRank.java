/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.aysfrisco.example;

import org.apache.avro.specific.SpecificData;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class UserRank extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 4484623996107203913L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"UserRank\",\"namespace\":\"com.aysfrisco.example\",\"fields\":[{\"name\":\"userId\",\"type\":\"int\"},{\"name\":\"rank\",\"type\":\"int\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public int userId;
  @Deprecated public int rank;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public UserRank() {}

  /**
   * All-args constructor.
   * @param userId The new value for userId
   * @param rank The new value for rank
   */
  public UserRank(java.lang.Integer userId, java.lang.Integer rank) {
    this.userId = userId;
    this.rank = rank;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return userId;
    case 1: return rank;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: userId = (java.lang.Integer)value$; break;
    case 1: rank = (java.lang.Integer)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'userId' field.
   * @return The value of the 'userId' field.
   */
  public java.lang.Integer getUserId() {
    return userId;
  }

  /**
   * Sets the value of the 'userId' field.
   * @param value the value to set.
   */
  public void setUserId(java.lang.Integer value) {
    this.userId = value;
  }

  /**
   * Gets the value of the 'rank' field.
   * @return The value of the 'rank' field.
   */
  public java.lang.Integer getRank() {
    return rank;
  }

  /**
   * Sets the value of the 'rank' field.
   * @param value the value to set.
   */
  public void setRank(java.lang.Integer value) {
    this.rank = value;
  }

  /**
   * Creates a new UserRank RecordBuilder.
   * @return A new UserRank RecordBuilder
   */
  public static com.aysfrisco.example.UserRank.Builder newBuilder() {
    return new com.aysfrisco.example.UserRank.Builder();
  }

  /**
   * Creates a new UserRank RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new UserRank RecordBuilder
   */
  public static com.aysfrisco.example.UserRank.Builder newBuilder(com.aysfrisco.example.UserRank.Builder other) {
    return new com.aysfrisco.example.UserRank.Builder(other);
  }

  /**
   * Creates a new UserRank RecordBuilder by copying an existing UserRank instance.
   * @param other The existing instance to copy.
   * @return A new UserRank RecordBuilder
   */
  public static com.aysfrisco.example.UserRank.Builder newBuilder(com.aysfrisco.example.UserRank other) {
    return new com.aysfrisco.example.UserRank.Builder(other);
  }

  /**
   * RecordBuilder for UserRank instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<UserRank>
    implements org.apache.avro.data.RecordBuilder<UserRank> {

    private int userId;
    private int rank;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.aysfrisco.example.UserRank.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.userId)) {
        this.userId = data().deepCopy(fields()[0].schema(), other.userId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.rank)) {
        this.rank = data().deepCopy(fields()[1].schema(), other.rank);
        fieldSetFlags()[1] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing UserRank instance
     * @param other The existing instance to copy.
     */
    private Builder(com.aysfrisco.example.UserRank other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.userId)) {
        this.userId = data().deepCopy(fields()[0].schema(), other.userId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.rank)) {
        this.rank = data().deepCopy(fields()[1].schema(), other.rank);
        fieldSetFlags()[1] = true;
      }
    }

    /**
      * Gets the value of the 'userId' field.
      * @return The value.
      */
    public java.lang.Integer getUserId() {
      return userId;
    }

    /**
      * Sets the value of the 'userId' field.
      * @param value The value of 'userId'.
      * @return This builder.
      */
    public com.aysfrisco.example.UserRank.Builder setUserId(int value) {
      validate(fields()[0], value);
      this.userId = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'userId' field has been set.
      * @return True if the 'userId' field has been set, false otherwise.
      */
    public boolean hasUserId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'userId' field.
      * @return This builder.
      */
    public com.aysfrisco.example.UserRank.Builder clearUserId() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'rank' field.
      * @return The value.
      */
    public java.lang.Integer getRank() {
      return rank;
    }

    /**
      * Sets the value of the 'rank' field.
      * @param value The value of 'rank'.
      * @return This builder.
      */
    public com.aysfrisco.example.UserRank.Builder setRank(int value) {
      validate(fields()[1], value);
      this.rank = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'rank' field has been set.
      * @return True if the 'rank' field has been set, false otherwise.
      */
    public boolean hasRank() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'rank' field.
      * @return This builder.
      */
    public com.aysfrisco.example.UserRank.Builder clearRank() {
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    public UserRank build() {
      try {
        UserRank record = new UserRank();
        record.userId = fieldSetFlags()[0] ? this.userId : (java.lang.Integer) defaultValue(fields()[0]);
        record.rank = fieldSetFlags()[1] ? this.rank : (java.lang.Integer) defaultValue(fields()[1]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  private static final org.apache.avro.io.DatumWriter
    WRITER$ = new org.apache.avro.specific.SpecificDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  private static final org.apache.avro.io.DatumReader
    READER$ = new org.apache.avro.specific.SpecificDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
