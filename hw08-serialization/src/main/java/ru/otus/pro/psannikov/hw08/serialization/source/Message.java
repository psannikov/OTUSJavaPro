package ru.otus.pro.psannikov.hw08.serialization.source;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Setter
@Getter
public class Message implements Serializable {
    private String chatIdentifier;
    private String membersLast;
    @JsonProperty("belong_number")
    private String belongNumber;
    @JsonProperty("send_date")
    @JsonFormat(pattern="MM-dd-yyyy HH:mm:ss")
    private LocalDateTime sendDate;
    @JsonProperty("text")
    private String text;
    @JsonCreator
    public Message(
            @JsonProperty("belong_number") String belongNumber,
            @JsonProperty("send_date") LocalDateTime sendDate,
            @JsonProperty("text") String text) {
        this.belongNumber = belongNumber;
        this.sendDate = sendDate;
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(chatIdentifier, message.chatIdentifier) && Objects.equals(membersLast, message.membersLast) && Objects.equals(belongNumber, message.belongNumber) && Objects.equals(sendDate, message.sendDate) && Objects.equals(text, message.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chatIdentifier, membersLast, belongNumber, sendDate, text);
    }
    @Override
    public String toString() {
        return String.format("Message: {chatIdentifier=%s, membersLast=%s, belongNumber=%s, sendDate=%s, text=%s}",chatIdentifier,membersLast,belongNumber,sendDate,text);
    }
}

