package space.stellario;

import com.hypixel.hytale.server.core.event.events.player.PlayerReadyEvent;
import com.hypixel.hytale.server.core.plugin.JavaPlugin;
import com.hypixel.hytale.server.core.plugin.JavaPluginInit;
import com.hypixel.hytale.server.core.util.Config;
import space.stellario.commands.ExampleCommand;
import space.stellario.config.ExampleConfig;
import space.stellario.events.ExampleEvent;

import javax.annotation.Nonnull;

public class CaliforniaNatives extends JavaPlugin {

    private static Config<ExampleConfig> config = null;

    public CaliforniaNatives(@Nonnull JavaPluginInit init) {
        super(init);
        config = this.withConfig("example_config", ExampleConfig.CODEC);
    }

    @Override
    protected void setup() {
        config.save();
        this.getCommandRegistry().registerCommand(new ExampleCommand("Hullo", "An example command that says hello."));
        if (getConfig().get().isEnabledWelcomeMessage()) {
            this.getEventRegistry().registerGlobal(PlayerReadyEvent.class, ExampleEvent::onPlayerReady);
        }
    }

    public static Config<ExampleConfig> getConfig() {
        return config;
    }
}