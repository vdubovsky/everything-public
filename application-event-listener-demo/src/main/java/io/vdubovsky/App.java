package io.vdubovsky;

import lombok.Getter;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@SpringBootApplication
@RequestMapping
@RestController
@Slf4j
@EnableAsync
public class App {

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @GetMapping("/sync")
    public ResponseEntity<ExecutionContext> syncListener() throws Exception {
        var start = LocalDateTime.now();
        Thread.sleep(1000);
        var context = new ExecutionContext(getExecutionResult("APP", start));
        var event = new InternalCustomApplicationEvent(context);
        eventPublisher.publishEvent(event);
        return ResponseEntity.ok(event.getExecutionContext());
    }

    @GetMapping("/async")
    public ResponseEntity<ExecutionContext> asyncListener() throws Exception {
        var start = LocalDateTime.now();
        Thread.sleep(1000);
        var context = new ExecutionContext(getExecutionResult("APP", start));
        var event = new InternalCustomApplicationAsyncEvent(context);
        eventPublisher.publishEvent(event);
        return ResponseEntity.ok(event.getExecutionContext());
    }

    @GetMapping("/async-and-wait")
    public ResponseEntity<ExecutionContext> asyncAndWaitListener() throws Exception {
        var start = LocalDateTime.now();
        Thread.sleep(1000);
        var context = new ExecutionContext(getExecutionResult("APP", start));
        var event = new InternalCustomApplicationAsyncEvent(context);
        eventPublisher.publishEvent(event);
        Thread.sleep(5000);
        return ResponseEntity.ok(event.getExecutionContext());
    }

    @Getter
    public static class ExecutionContext {
        private final Set<ExecutionResult> results = ConcurrentHashMap.newKeySet();

        public ExecutionContext(ExecutionResult executionResult) {
            results.add(executionResult);
        }

    }


    public record ExecutionResult(
            UUID id, String executor, String threadName, LocalDateTime startTime, LocalDateTime endTime) {
    }

    @Value
    public static class InternalCustomApplicationEvent {
        ExecutionContext executionContext;
    }

    @Value
    public static class InternalCustomApplicationAsyncEvent {
        ExecutionContext executionContext;
    }

    @Component
    public static class CustomApplicationSyncEventListener1 {

        @EventListener
        public void listen(InternalCustomApplicationEvent event) throws Exception {
            var start = LocalDateTime.now();
            Thread.sleep(1000);
            event.getExecutionContext().getResults().add(getExecutionResult("SYNC 1", start));
        }
    }

    @Component
    public static class CustomApplicationSyncEventListener2 {

        @EventListener
        public void listen(InternalCustomApplicationEvent event) throws Exception {
            var start = LocalDateTime.now();
            Thread.sleep(1000);
            event.getExecutionContext().getResults().add(getExecutionResult("SYNC 2", start));
        }
    }

    @Component
    public static class CustomApplicationAsyncEventListener1 {

        @Async
        @EventListener
        public void listen(InternalCustomApplicationAsyncEvent event) throws Exception {
            var start = LocalDateTime.now();
            Thread.sleep(1000);
            event.getExecutionContext().getResults().add(getExecutionResult("ASYNC 1", start));
        }
    }

    @Component
    public static class CustomApplicationAsyncEventListener2 {

        @Async
        @EventListener
        public void listen(InternalCustomApplicationAsyncEvent event) throws Exception {
            var start = LocalDateTime.now();
            Thread.sleep(1000);
            event.getExecutionContext().getResults().add(getExecutionResult("ASYNC 2", start));
        }
    }


    public static ExecutionResult getExecutionResult(String executor, LocalDateTime startTime) {
        return new ExecutionResult(UUID.randomUUID(), executor, Thread.currentThread().getName(), startTime, LocalDateTime.now());
    }
}
