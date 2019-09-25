package com.moon.systemweb.config;
import com.moon.systemapi.entity.User;
import com.moon.systemweb.mq.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.PayloadApplicationEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class UserTransactionEventListener {
    @Autowired
    private Producer producer;

    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void beforeCommit(PayloadApplicationEvent<User> event) {
        System.out.println("before commit, id: " + event.getPayload().getId());
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void afterCommit(PayloadApplicationEvent<User> event) {
        System.out.println("after commit, id: " + event.getPayload().getId());
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMPLETION)
    public void afterCompletion(PayloadApplicationEvent<User> event) {
        System.out.println("after completion, id: " + event.getPayload().getId());
        producer.send("topicExchange","key.1","草拟吗");
        //messageSender.send(UserCenterMq.MQ_EXCHANGE_USER,"post.redpacket", JSONObject.toJSONString(event.getPayload()));
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_ROLLBACK)
    public void afterRollback(PayloadApplicationEvent<User> event) {
        System.out.println("after rollback, id: " + event.getPayload().getId());
    }
}