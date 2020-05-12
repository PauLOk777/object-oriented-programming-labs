package com.paul.lab4;

public class PlainOldJavaObject {
    private String name;
    private String type;
    private String version;

    PlainOldJavaObject(String name, String type, String version) {
        this.name = name;
        this.type = type;
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + name.hashCode();
        result = 31 * result + type.hashCode();
        result = 31 * result + version.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || this.getClass() != obj.getClass())
            return false;
        PlainOldJavaObject other = (PlainOldJavaObject) obj;
        return this.name.equals(other.name) && this.type.equals(other.type) && this.version.equals(other.version);
    }

    @Override
    public String toString() {
        return "Name: " + name + " Type: " + type + " Version: " + version;
    }
}
