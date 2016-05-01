package br.com.logique.easyspark;

import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by Gustavo on 29/04/2016.
 */
public class IogiParameterTest {

    public IogiParameterTest(String name, int value) {
        this.name = name;
        this.value = value;
    }

    private String name;

    private int value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        IogiParameterTest that = (IogiParameterTest) o;

        return new org.apache.commons.lang3.builder.EqualsBuilder()
                .append(value, that.value)
                .append(name, that.name)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(name)
                .append(value)
                .toHashCode();
    }
}
