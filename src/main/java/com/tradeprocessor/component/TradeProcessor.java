package com.tradeprocessor.component;

import com.tradeprocessor.message.Message;
import com.tradeprocessor.message.TradeMessage;
import com.tradeprocessor.service.KafkaTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TradeProcessor {

    private final KafkaTemplate<String, TradeMessage> kafkaTemplate;

    @Autowired
    public TradeProcessor(KafkaTemplate<String, TradeMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    /**
     * Handles incoming FIX messages.
     * Ex: 8=FIX.4.4|35=8|17=ExecID123|48=XYZ123|22=4|1=AccountXYZ|32=100|6=49.75|8=BUY|
     */

    public void onMessage(Message msg) {
        TradeMessage tradeMessage = createTradeMessageFromFixMessage(msg);
        sendTradeMessageToKafka(tradeMessage);
    }

    private TradeMessage createTradeMessageFromFixMessage(Message msg) {
        TradeMessage tradeMessage = new TradeMessage();
        tradeMessage.tradeId = msg.getExecId();
        tradeMessage.securityId = msg.getSecurityId();
        tradeMessage.account = msg.getAccount();
        tradeMessage.qty = msg.getLastShares();
        tradeMessage.price = msg.getAvgPx();
        tradeMessage.ticker = msg.getSide();

        String securityIdSource = String.valueOf(msg.getSecurityIdSource());
        setTradeMessageIdSource(securityIdSource, tradeMessage);

        return tradeMessage;
    }

    private void setTradeMessageIdSource(String securityIdSource, TradeMessage tradeMessage) {
        switch (securityIdSource) {
            case "ISIN":
                tradeMessage.idSource = TradeMessage.IdSource.ISIN;
                tradeMessage.isin = tradeMessage.securityId;
                break;
            case "CUSIP":
                tradeMessage.idSource = TradeMessage.IdSource.CUSIP;
                tradeMessage.cusip = tradeMessage.securityId;
                break;
            case "SEDOL":
                tradeMessage.idSource = TradeMessage.IdSource.SEDOL;
                tradeMessage.sedol = tradeMessage.securityId;
                break;
            case "RIC":
                tradeMessage.idSource = TradeMessage.IdSource.RIC;
                tradeMessage.ric = tradeMessage.securityId;
                break;
            default:
                break;
        }
    }

    private void sendTradeMessageToKafka(TradeMessage tradeMessage) {
        kafkaTemplate.sendDefault(tradeMessage.tradeId, tradeMessage);
    }
}
