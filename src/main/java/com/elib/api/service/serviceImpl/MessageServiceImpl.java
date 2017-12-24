package com.elib.api.service.serviceImpl;

import com.elib.api.service.MessageService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    private Long memberId;

    @Override
    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    @Override
    public Long getMemberId() {
        return memberId;
    }

    @Override
    public List<String> getAllMessages() {
        return null;
    }

    @Override
    public boolean postmessage() {
        return false;
    }
}
