# InventoryFilter [![CircleCI](https://circleci.com/gh/cooper-anderson-mc/InventoryFilter.svg?style=shield)](https://circleci.com/gh/cooper-anderson-mc/InventoryFilter) [![CurseForge](http://cf.way2muchnoise.eu/full_inventoryfilter_downloads.svg)](https://minecraft.curseforge.com/projects/inventoryfilter)
InventoryFilter is a mod for Minecraft `1.12.2+`. It enables you to whitelist or blacklist your inventory to only allow certain items in.

In the config screen of the mod you can:
 * quickly enable/disable the mod
 * switch if the filter is a whitelist or blacklist
 * set which gamemodes the filter applies to
 * and most importantly, change the filtered item list

The filter also allows for [Regular Expressions](https://en.wikipedia.org/wiki/Regular_expression), so you can filter items to your heart's content.

## Requirements
 * Minecraft with Forge version `14.23.4.2713` or higher

## Installation
 * It is recommended to install via the [Twitch Desktop App](https://app.twitch.tv/download)'s Minecraft mod manager
 * If for some reason you must install it manually, just drop the .jar file in the mods folder in your minecraft directory as usual

## Contributing
You are welcome to contribute in any way, whether it be bug reporting or pull requests. Here are the instructions on settings up a development environment for the mod:

```bash
# Clone the repository:
git clone https://github.com/cooper-anderson-mc/InventoryFilter && cd InventoryFilter;
# Setup Forge and decompile Minecraft:
./gradlew setupDecompWorkspace;
# Run Client when desired:
./gradlew runClient;
```

## Images
### Config Screen
![Config Screen](docs/config_screen.png?raw=true "test")

### Filter List Screen
![Filter List Screen](docs/filter_list.png?raw=true "test")

## Modpacks
You are free to include this mod in any modpack you wish.
