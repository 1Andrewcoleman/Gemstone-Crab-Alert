# Gemstone Crab Alert

A RuneLite plugin that provides visual alerts when the Gemstone Crab's health drops to critical levels. Features customizable flashing effects, health thresholds, and flash duration settings.

## Features

- **Visual Alert System**: Flashing screen overlay when Gemstone Crab health reaches your configured threshold
- **Customizable Flash Color**: Choose any color for the alert flash (includes transparency/alpha support)
- **Configurable Health Threshold**: Set the health percentage at which the alert triggers (default: 5%)
- **Adjustable Flash Duration**: Control how long the alert lasts (1-30 seconds, default: 5 seconds)
- **Pulsing Flash Effect**: Fast on/off flashing pattern (configurable speed, default: 250ms intervals)
- **Precise Triggering**: Alerts trigger exactly when health reaches or drops below the threshold

## Installation

### For Development (Sideloaded Plugin)

1. **Build the plugin:**
   ```bash
   cd gemstone-crab-plugin
   ./gradlew clean jar
   ```

2. **Deploy to RuneLite:**
   ```bash
   cp build/libs/gemstone-crab-plugin-1.0.0.jar ~/.runelite/sideloaded-plugins/
   ```

3. **Launch RuneLite in developer mode:**
   ```bash
   ./launch-runelite.sh
   ```
   
   Or manually:
   ```bash
   ./gradlew run
   ```

4. **Enable the plugin:**
   - Open RuneLite settings
   - Go to Plugins
   - Find "Gemstone Crab Alert"
   - Toggle it ON

### Requirements

- Java 11 or higher
- RuneLite client
- Developer mode enabled (for sideloaded plugins)

## Configuration

Access plugin settings via: **RuneLite Settings → Plugins → Gemstone Crab Alert**

### Settings

| Setting | Default | Range | Description |
|---------|---------|-------|-------------|
| **Flash Color** | Red (255, 0, 0) | Color picker | The color of the screen flash alert |
| **Health Threshold %** | 5 | 1-99 | Alert triggers when health is at or below this percentage |
| **Flash Duration (seconds)** | 5 | 1-30 | Total duration of the flashing alert |
| **Flash Interval (ms)** | 250 | 100-1000 | Speed of on/off flashing (lower = faster) |

### Recommended Settings

- **Fast, noticeable alert**: Flash Interval = 200ms, Duration = 5 seconds
- **Subtle alert**: Flash Interval = 500ms, Duration = 3 seconds
- **Long warning**: Duration = 10 seconds, Flash Interval = 250ms

## How It Works

1. The plugin monitors all NPCs in the game area
2. When a "Gemstone Crab" is detected, it calculates health percentage
3. If health ≤ threshold (and > 0), the flash alert activates
4. The screen flashes on/off rapidly for the configured duration
5. Alert automatically stops after the duration expires or if health recovers above threshold

## Building from Source

### Prerequisites

- Java JDK 11 or higher
- Gradle (wrapper included)

### Build Steps

```bash
# Clone or download the project
cd gemstone-crab-plugin

# Build the plugin JAR
./gradlew clean jar

# The JAR will be in: build/libs/gemstone-crab-plugin-1.0.0.jar
```

### Project Structure

```
gemstone-crab-plugin/
├── src/
│   ├── main/
│   │   ├── java/com/gemstonecrab/
│   │   │   ├── GemstoneCrabPlugin.java      # Main plugin class
│   │   │   ├── GemstoneCrabConfig.java      # Configuration interface
│   │   │   └── GemstoneCrabOverlay.java     # Visual overlay renderer
│   │   └── resources/
│   │       └── runelite-plugin.properties   # Plugin metadata
│   └── test/
│       └── java/com/gemstonecrab/
│           └── GemstoneCrabPluginTest.java  # Test runner
├── build.gradle                              # Build configuration
├── settings.gradle                          # Gradle settings
└── launch-runelite.sh                       # Launch script
```

## Troubleshooting

### Plugin Not Appearing

- Ensure the JAR is in `~/.runelite/sideloaded-plugins/`
- Verify RuneLite is running in developer mode (`--developer-mode` flag)
- Check that only ONE copy of the plugin JAR exists
- Restart RuneLite completely

### Alert Not Triggering

- Verify the plugin is enabled in RuneLite settings
- Check that health threshold is set correctly
- Ensure you're fighting a "Gemstone Crab" (exact name match)
- Check RuneLite logs: `~/.runelite/logs/client.log` for debug messages

### Duplicate Plugin Entries

- Remove any duplicate JARs from `~/.runelite/plugins/` or `~/.runelite/sideloaded-plugins/`
- Ensure only one `runelite-plugin.properties` file exists in `src/main/resources/`
- Clean and rebuild: `./gradlew clean jar`

### Flash Not Visible

- Check that "Flash Color" opacity/alpha is set high enough
- Verify "Flash Enabled" toggle is ON (if available)
- Try increasing Flash Interval for slower, more visible flashes

## Technical Details

- **Game Tick Rate**: Checks health every game tick (~0.6 seconds)
- **Health Calculation**: `(healthRatio / healthScale) * 100`
- **Flash Pattern**: Alternating on/off cycles based on Flash Interval
- **Config Storage**: Settings saved in `~/.runelite/profiles2/` per profile

## License

This plugin is provided as-is for personal use. Modify and distribute as needed.

## Credits

- Built for RuneLite plugin API
- Uses RuneLite's overlay and configuration systems
- Compatible with RuneLite 1.12.12.1+

## Support

For issues or questions:
1. Check RuneLite logs: `~/.runelite/logs/client.log`
2. Verify plugin is enabled and configured correctly
3. Ensure RuneLite is up to date
4. Rebuild and redeploy if issues persist

---

**Note**: This plugin is for development/testing purposes. For production use, consider submitting to the RuneLite Plugin Hub.
