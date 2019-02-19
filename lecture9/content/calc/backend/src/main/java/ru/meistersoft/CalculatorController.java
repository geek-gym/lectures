package ru.meistersoft;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController()
public class CalculatorController {

    private Map<UUID, CommandExecutor> storage;
    public CalculatorController() {
        this.storage = new HashMap<>();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/api/calculator")
    public String createCalculator() {
        UUID id = UUID.randomUUID();
        CommandExecutor executor = new CommandExecutor(new CalculatorStack());
        this.storage.put(id, executor);
        return id.toString();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/api/calculator/{id}")
    public @ResponseBody Value getCalculatorState(@PathVariable(value = "id") String id) {
        return new Value(this.storage.get(UUID.fromString(id)).GetState());
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/api/calculator/{id}")
    public @ResponseBody Value sendCommand(@PathVariable(value = "id") String id, @RequestBody Value command) {
        CommandExecutor executor = this.storage.get(UUID.fromString(id));
        executor.PushCommand(command.getValue());
        return new Value(executor.GetState());
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/api/calculator/{id}")
    public void deleteCalculator(@PathVariable(value = "id") String id) {
        this.storage.remove(UUID.fromString(id));
    }
}