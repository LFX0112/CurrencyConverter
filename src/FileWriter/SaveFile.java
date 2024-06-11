package FileWriter;

public class SaveFile {
    private String exchange;
    private String fromExchange;
    private String toExchange;
    private Double incoming;
    private Double conversion;
    public SaveFile(String exchange, String fromExchange, String toExchange, Double incoming, Double conversion)
    {
        this.exchange = exchange;
        this.fromExchange = fromExchange;
        this.toExchange = toExchange;
        this.incoming = incoming;
        this.conversion = conversion;
    }

    @Override
    public String toString() {
        return
                "exchange rate: " + exchange + '\'' +
                        "value: " + incoming + " "+ fromExchange +'\'' +
                        "total: " + conversion + " "+ toExchange +'\'';
    }
}