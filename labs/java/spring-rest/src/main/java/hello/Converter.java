package hello;

class Converter {
    private static final String template = "Hello, %s!";
    
    public String convert(String name) {
        return String.format(template, name);
    }
}
