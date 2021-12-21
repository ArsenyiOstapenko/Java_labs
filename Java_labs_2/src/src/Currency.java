class Currency {
    private String Name;
    private String NumCode;
    private String CharCode;
    private String Scale;
    private String Rate;
    private int Id;


    public void setName(String name) {
        Name = name;
    }

    public void setNumCode(String numCode) {
        NumCode = numCode;
    }

    public void setCharCode(String charCode) {
        CharCode = charCode;
    }

    public void setScale(String scale) {
        Scale = scale;
    }

    public void setRate(String rate) {
        Rate = rate;
    }

    public void setId(int id) {
        Id = id;
    }

    @Override
    public String toString() {
        return "Currency: " +
                "Name='" + Name + '\'' +
                ", NumCode='" + NumCode + '\'' +
                ", CharCode='" + CharCode + '\'' +
                ", Scale='" + Scale + '\'' +
                ", Rate='" + Rate + '\'' +
                ", Id='" + Id + '\'';
    }
}
