package com.example.persistence;

import java.util.Arrays;

@SuppressWarnings("WeakerAccess")
public class Data {
    private String id;
    private String name;
    private Object[] values;

    // checking each index and turn into string if index is integer
    private void ConvertIntegersToStrings(Object[] myValues)
    {
        // checking each index
        for (int i = 0; i < myValues.length; i++)
        {
            // store one index in a value
            Object value = myValues[i];

            // if index has a integer then turn into a string and initialize
            if (value instanceof Integer)
            {
                this.values[i] = String.valueOf(value);
            }
            else
            {
                this.values[i] = value;
            }
        }
    }
    public Data(String id, String name, Object ... values) {
        this.id = id;
        this.name = name;

        // calculate how many index and initialize
        this.values = new Object[values.length];

        ConvertIntegersToStrings(values);
    }

    public String getID() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public String[] getValues() {

        String[] stringValues = new String[this.values.length];

        for (int i = 0; i < this.values.length; i++)
        {
            stringValues[i] = String.valueOf(values[i]);
        }

        return stringValues;
    }
    public void setID(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setValues(Object ... values) {

        ConvertIntegersToStrings(values);
    }

    @Override
    public String toString() {
        return "Mountain{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", values=" + Arrays.toString(values) +
                '}';
    }
}
