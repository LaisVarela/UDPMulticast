package udpmulticast;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Client {

    private LocalDate date_value;
    private LocalTime time_value;
    private String nome;
    private String msg;

    public Client() {
    }

    public Client(LocalDate date_value, LocalTime time_value, String nome, String msg) {
        this.date_value = date_value;
        this.time_value = time_value;
        this.nome = nome;
        this.msg = msg;
    }

    public LocalDate getDate_value() {
        return date_value;
    }

    public void setDate_value(LocalDate date_value) {
        this.date_value = date_value;
    }

    public LocalTime getTime_value() {
        return time_value;
    }

    public void setTime_value(LocalTime time_value) {
        this.time_value = time_value;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return nome + " |" + time_value.format(timeFormatter) + "  "
                + date_value.format(dateFormatter) + "|\n> " + msg + "\n\n";
    }

}
