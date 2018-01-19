package masterSpringMvc.services;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Component;

@Component
public class GreetService {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

	public GreetModel getGreet(String name) {
        return new GreetModel(counter.incrementAndGet(),
                String.format(template, name));
	}
}
