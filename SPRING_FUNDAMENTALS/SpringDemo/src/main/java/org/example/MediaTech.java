package org.example;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class MediaTech implements MobileProcesser{

    @Override
    public void process() {
        System.out.println("Worlds second best processor");
    }
}
