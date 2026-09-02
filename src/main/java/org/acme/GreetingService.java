package org.acme;

import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;

@RegisterAiService
public interface GreetingService {
    
    @UserMessage("""
            Generates a greeting message for {{name}}
            """)
    String generate(String name);
}
