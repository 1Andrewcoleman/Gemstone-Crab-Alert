#!/bin/bash
# Launch RuneLite with Gemstone Crab Alert plugin
# This will use saved Jagex Account credentials from the launcher

cd /Users/andrewlovellecoleman/Downloads/gemstone-crab-plugin
export JAVA_HOME=/opt/homebrew/opt/java11
export PATH="$JAVA_HOME/bin:$PATH"

echo "Launching RuneLite with Gemstone Crab Alert plugin..."
echo "This will read your Jagex Account credentials from ~/.runelite/credentials.properties"
echo ""

./gradlew run
