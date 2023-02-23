package org.example;

import org.springframework.stereotype.Component;

@Component
public class Snapdragon implements MobileProcesser{
    @Override
    public void process() {
        System.out.println("Worlds best processor");
    }
}
