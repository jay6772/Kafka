/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package JP.kafkaavro.demokafkaavroproducer.avro;

import org.apache.avro.specific.SpecificData;

import lombok.Builder;

import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
@Builder
public class PersonAvro extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 6049484958877932604L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Person\",\"namespace\":\"JP.kafkaavro.demokafkaavroproducer.avro\",\"fields\":[{\"name\":\"lastName\",\"type\":\"string\",\"doc\":\"the last name of a person\"},{\"name\":\"firstName\",\"type\":\"string\",\"doc\":\"the first name of a person\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<PersonAvro> ENCODER =
      new BinaryMessageEncoder<PersonAvro>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<PersonAvro> DECODER =
      new BinaryMessageDecoder<PersonAvro>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<PersonAvro> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<PersonAvro> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<PersonAvro>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this Person to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a Person from a ByteBuffer. */
  public static PersonAvro fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  /** the last name of a person */
  @Deprecated public java.lang.CharSequence lastName;
  /** the first name of a person */
  @Deprecated public java.lang.CharSequence firstName;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public PersonAvro() {}

  /**
   * All-args constructor.
   * @param lastName the last name of a person
   * @param firstName the first name of a person
   */
  public PersonAvro(java.lang.CharSequence lastName, java.lang.CharSequence firstName) {
    this.lastName = lastName;
    this.firstName = firstName;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return lastName;
    case 1: return firstName;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: lastName = (java.lang.CharSequence)value$; break;
    case 1: firstName = (java.lang.CharSequence)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'lastName' field.
   * @return the last name of a person
   */
  public java.lang.CharSequence getLastName() {
    return lastName;
  }

  /**
   * Sets the value of the 'lastName' field.
   * the last name of a person
   * @param value the value to set.
   */
  public void setLastName(java.lang.CharSequence value) {
    this.lastName = value;
  }

  /**
   * Gets the value of the 'firstName' field.
   * @return the first name of a person
   */
  public java.lang.CharSequence getFirstName() {
    return firstName;
  }

  /**
   * Sets the value of the 'firstName' field.
   * the first name of a person
   * @param value the value to set.
   */
  public void setFirstName(java.lang.CharSequence value) {
    this.firstName = value;
  }

  /**
   * Creates a new Person RecordBuilder.
   * @return A new Person RecordBuilder
   */
  public static JP.kafkaavro.demokafkaavroproducer.avro.PersonAvro.Builder newBuilder() {
    return new JP.kafkaavro.demokafkaavroproducer.avro.PersonAvro.Builder();
  }

  /**
   * Creates a new Person RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Person RecordBuilder
   */
  public static JP.kafkaavro.demokafkaavroproducer.avro.PersonAvro.Builder newBuilder(JP.kafkaavro.demokafkaavroproducer.avro.PersonAvro.Builder other) {
    return new JP.kafkaavro.demokafkaavroproducer.avro.PersonAvro.Builder(other);
  }

  /**
   * Creates a new Person RecordBuilder by copying an existing Person instance.
   * @param other The existing instance to copy.
   * @return A new Person RecordBuilder
   */
  public static JP.kafkaavro.demokafkaavroproducer.avro.PersonAvro.Builder newBuilder(JP.kafkaavro.demokafkaavroproducer.avro.PersonAvro other) {
    return new JP.kafkaavro.demokafkaavroproducer.avro.PersonAvro.Builder(other);
  }

  /**
   * RecordBuilder for Person instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<PersonAvro>
    implements org.apache.avro.data.RecordBuilder<PersonAvro> {

    /** the last name of a person */
    private java.lang.CharSequence lastName;
    /** the first name of a person */
    private java.lang.CharSequence firstName;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(JP.kafkaavro.demokafkaavroproducer.avro.PersonAvro.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.lastName)) {
        this.lastName = data().deepCopy(fields()[0].schema(), other.lastName);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.firstName)) {
        this.firstName = data().deepCopy(fields()[1].schema(), other.firstName);
        fieldSetFlags()[1] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing Person instance
     * @param other The existing instance to copy.
     */
    private Builder(JP.kafkaavro.demokafkaavroproducer.avro.PersonAvro other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.lastName)) {
        this.lastName = data().deepCopy(fields()[0].schema(), other.lastName);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.firstName)) {
        this.firstName = data().deepCopy(fields()[1].schema(), other.firstName);
        fieldSetFlags()[1] = true;
      }
    }

    /**
      * Gets the value of the 'lastName' field.
      * the last name of a person
      * @return The value.
      */
    public java.lang.CharSequence getLastName() {
      return lastName;
    }

    /**
      * Sets the value of the 'lastName' field.
      * the last name of a person
      * @param value The value of 'lastName'.
      * @return This builder.
      */
    public JP.kafkaavro.demokafkaavroproducer.avro.PersonAvro.Builder setLastName(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.lastName = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'lastName' field has been set.
      * the last name of a person
      * @return True if the 'lastName' field has been set, false otherwise.
      */
    public boolean hasLastName() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'lastName' field.
      * the last name of a person
      * @return This builder.
      */
    public JP.kafkaavro.demokafkaavroproducer.avro.PersonAvro.Builder clearLastName() {
      lastName = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'firstName' field.
      * the first name of a person
      * @return The value.
      */
    public java.lang.CharSequence getFirstName() {
      return firstName;
    }

    /**
      * Sets the value of the 'firstName' field.
      * the first name of a person
      * @param value The value of 'firstName'.
      * @return This builder.
      */
    public JP.kafkaavro.demokafkaavroproducer.avro.PersonAvro.Builder setFirstName(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.firstName = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'firstName' field has been set.
      * the first name of a person
      * @return True if the 'firstName' field has been set, false otherwise.
      */
    public boolean hasFirstName() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'firstName' field.
      * the first name of a person
      * @return This builder.
      */
    public JP.kafkaavro.demokafkaavroproducer.avro.PersonAvro.Builder clearFirstName() {
      firstName = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public PersonAvro build() {
      try {
        PersonAvro record = new PersonAvro();
        record.lastName = fieldSetFlags()[0] ? this.lastName : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.firstName = fieldSetFlags()[1] ? this.firstName : (java.lang.CharSequence) defaultValue(fields()[1]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<PersonAvro>
    WRITER$ = (org.apache.avro.io.DatumWriter<PersonAvro>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<PersonAvro>
    READER$ = (org.apache.avro.io.DatumReader<PersonAvro>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
