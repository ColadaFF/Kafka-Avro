/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package Message;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class EventMessage extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"EventMessage\",\"namespace\":\"Message\",\"fields\":[{\"name\":\"machine\",\"type\":\"string\"},{\"name\":\"id\",\"type\":\"string\"},{\"name\":\"date\",\"type\":\"long\"},{\"name\":\"status\",\"type\":\"float\"},{\"name\":\"building\",\"type\":\"string\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public CharSequence machine;
  @Deprecated public CharSequence id;
  @Deprecated public long date;
  @Deprecated public float status;
  @Deprecated public CharSequence building;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public EventMessage() {}

  /**
   * All-args constructor.
   */
  public EventMessage(CharSequence machine, CharSequence id, Long date, Float status, CharSequence building) {
    this.machine = machine;
    this.id = id;
    this.date = date;
    this.status = status;
    this.building = building;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public Object get(int field$) {
    switch (field$) {
    case 0: return machine;
    case 1: return id;
    case 2: return date;
    case 3: return status;
    case 4: return building;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, Object value$) {
    switch (field$) {
    case 0: machine = (CharSequence)value$; break;
    case 1: id = (CharSequence)value$; break;
    case 2: date = (Long)value$; break;
    case 3: status = (Float)value$; break;
    case 4: building = (CharSequence)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'machine' field.
   */
  public CharSequence getMachine() {
    return machine;
  }

  /**
   * Sets the value of the 'machine' field.
   * @param value the value to set.
   */
  public void setMachine(CharSequence value) {
    this.machine = value;
  }

  /**
   * Gets the value of the 'id' field.
   */
  public CharSequence getId() {
    return id;
  }

  /**
   * Sets the value of the 'id' field.
   * @param value the value to set.
   */
  public void setId(CharSequence value) {
    this.id = value;
  }

  /**
   * Gets the value of the 'date' field.
   */
  public Long getDate() {
    return date;
  }

  /**
   * Sets the value of the 'date' field.
   * @param value the value to set.
   */
  public void setDate(Long value) {
    this.date = value;
  }

  /**
   * Gets the value of the 'status' field.
   */
  public Float getStatus() {
    return status;
  }

  /**
   * Sets the value of the 'status' field.
   * @param value the value to set.
   */
  public void setStatus(Float value) {
    this.status = value;
  }

  /**
   * Gets the value of the 'building' field.
   */
  public CharSequence getBuilding() {
    return building;
  }

  /**
   * Sets the value of the 'building' field.
   * @param value the value to set.
   */
  public void setBuilding(CharSequence value) {
    this.building = value;
  }

  /** Creates a new EventMessage RecordBuilder */
  public static Builder newBuilder() {
    return new Builder();
  }
  
  /** Creates a new EventMessage RecordBuilder by copying an existing Builder */
  public static Builder newBuilder(Builder other) {
    return new Builder(other);
  }
  
  /** Creates a new EventMessage RecordBuilder by copying an existing EventMessage instance */
  public static Builder newBuilder(EventMessage other) {
    return new Builder(other);
  }
  
  /**
   * RecordBuilder for EventMessage instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<EventMessage>
    implements org.apache.avro.data.RecordBuilder<EventMessage> {

    private CharSequence machine;
    private CharSequence id;
    private long date;
    private float status;
    private CharSequence building;

    /** Creates a new Builder */
    private Builder() {
      super(EventMessage.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.machine)) {
        this.machine = data().deepCopy(fields()[0].schema(), other.machine);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.id)) {
        this.id = data().deepCopy(fields()[1].schema(), other.id);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.date)) {
        this.date = data().deepCopy(fields()[2].schema(), other.date);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.status)) {
        this.status = data().deepCopy(fields()[3].schema(), other.status);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.building)) {
        this.building = data().deepCopy(fields()[4].schema(), other.building);
        fieldSetFlags()[4] = true;
      }
    }
    
    /** Creates a Builder by copying an existing EventMessage instance */
    private Builder(EventMessage other) {
            super(EventMessage.SCHEMA$);
      if (isValidValue(fields()[0], other.machine)) {
        this.machine = data().deepCopy(fields()[0].schema(), other.machine);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.id)) {
        this.id = data().deepCopy(fields()[1].schema(), other.id);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.date)) {
        this.date = data().deepCopy(fields()[2].schema(), other.date);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.status)) {
        this.status = data().deepCopy(fields()[3].schema(), other.status);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.building)) {
        this.building = data().deepCopy(fields()[4].schema(), other.building);
        fieldSetFlags()[4] = true;
      }
    }

    /** Gets the value of the 'machine' field */
    public CharSequence getMachine() {
      return machine;
    }
    
    /** Sets the value of the 'machine' field */
    public Builder setMachine(CharSequence value) {
      validate(fields()[0], value);
      this.machine = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'machine' field has been set */
    public boolean hasMachine() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'machine' field */
    public Builder clearMachine() {
      machine = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'id' field */
    public CharSequence getId() {
      return id;
    }
    
    /** Sets the value of the 'id' field */
    public Builder setId(CharSequence value) {
      validate(fields()[1], value);
      this.id = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'id' field has been set */
    public boolean hasId() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'id' field */
    public Builder clearId() {
      id = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'date' field */
    public Long getDate() {
      return date;
    }
    
    /** Sets the value of the 'date' field */
    public Builder setDate(long value) {
      validate(fields()[2], value);
      this.date = value;
      fieldSetFlags()[2] = true;
      return this; 
    }
    
    /** Checks whether the 'date' field has been set */
    public boolean hasDate() {
      return fieldSetFlags()[2];
    }
    
    /** Clears the value of the 'date' field */
    public Builder clearDate() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /** Gets the value of the 'status' field */
    public Float getStatus() {
      return status;
    }
    
    /** Sets the value of the 'status' field */
    public Builder setStatus(float value) {
      validate(fields()[3], value);
      this.status = value;
      fieldSetFlags()[3] = true;
      return this; 
    }
    
    /** Checks whether the 'status' field has been set */
    public boolean hasStatus() {
      return fieldSetFlags()[3];
    }
    
    /** Clears the value of the 'status' field */
    public Builder clearStatus() {
      fieldSetFlags()[3] = false;
      return this;
    }

    /** Gets the value of the 'building' field */
    public CharSequence getBuilding() {
      return building;
    }
    
    /** Sets the value of the 'building' field */
    public Builder setBuilding(CharSequence value) {
      validate(fields()[4], value);
      this.building = value;
      fieldSetFlags()[4] = true;
      return this; 
    }
    
    /** Checks whether the 'building' field has been set */
    public boolean hasBuilding() {
      return fieldSetFlags()[4];
    }
    
    /** Clears the value of the 'building' field */
    public Builder clearBuilding() {
      building = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    @Override
    public EventMessage build() {
      try {
        EventMessage record = new EventMessage();
        record.machine = fieldSetFlags()[0] ? this.machine : (CharSequence) defaultValue(fields()[0]);
        record.id = fieldSetFlags()[1] ? this.id : (CharSequence) defaultValue(fields()[1]);
        record.date = fieldSetFlags()[2] ? this.date : (Long) defaultValue(fields()[2]);
        record.status = fieldSetFlags()[3] ? this.status : (Float) defaultValue(fields()[3]);
        record.building = fieldSetFlags()[4] ? this.building : (CharSequence) defaultValue(fields()[4]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
