public class Model {

    private String name;
    private Double temp;
    private Double humidity;
    private Double speed;
    private Double pressure;
    private String description;
    private String date;

    public String getDate() {return date;}
    public void setDate(String date) {this.date = date;}

    public String getName() {return name; }
        public void setName(String name) {this.name = name;}

    public Double getTemp() {
        return temp;
    }
    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public Double getHumidity() {
        return humidity;
    }
    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Double getSpeed() {
        return speed;
    }
    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPressure(){return pressure;}
    public void setPressure(Double pressure) {this.pressure = pressure*100/133.3;}


    @Override
    public String toString() {
        return "\uD83D\uDD70 Time: " + date + '\n' +
                "\uD83C\uDF21 Temperature: " + temp + "°C" +'\n' +
                "\uD83D\uDCA7 Humidity: " + humidity + "%" + '\n' +
                "\uD83C\uDF2A Wind speed: " + speed + " km/h" + '\n' +
                "\uD83D\uDDFF Pressure: " + String.format("%.2f", pressure) + " mm Hg" + '\n' +
                "\uD83C\uDF26 Skies: " + description + '\n' + '\n';
    }
}
