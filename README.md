# Cobblemon Granular Shinies

v1.8.4-1.1

[Modrinth](https://modrinth.com/mod/cobblemon-granularshinies)

[CurseForge](https://www.curseforge.com/minecraft/mc-mods/cobblemon-granularshinies)

[GitHub](https://github.com/timinc-cobble/cobblemon-granular-shinies)

## What if…

…you could set different shiny odds for different Pokémon?

## Features

- Override Cobblemon's shiny chance using Pokémon Properties, including species and forms.
- Give each matching property set its own shiny rate. The first matching entry wins.
- Reload the configuration through Tim Core's config reload command.

## Dependencies

- [Cobblemon](https://modrinth.com/mod/cobblemon)
- [Cobblemon Tim Core](https://modrinth.com/mod/cobblemon-tim-core)

## Configuration

After starting the game once, edit `config/cobblemon_granularshinies.json`. Values are shiny chance denominators: `1.0` gives a 1-in-1 chance, `20.0` gives a 1-in-20 chance, and `0` disables shiny rolls for matches.

```json
{
  "debug": false,
  "overrides": {
    "moltres": 20.0,
    "ponyta form=galarian": 100.0
  }
}
```

Overrides are evaluated in file order, and the first matching Pokémon Properties expression sets the rate. Entries without a species constraint can match Pokémon across multiple species; an unrecognized species name may therefore act as a broad match.

## Testing

Set `"magikarp": 1.0` in `overrides`, reload the config, then spawn Magikarp without explicitly setting its shiny property. Each new Magikarp should be shiny. Remove the test override when finished.

## Known Issues

- None currently documented.

## Roadmap

To follow development, join the [Discord](https://discord.com/invite/WKAR27SdSv).

## Feedback

Report problems in [GitHub Issues](https://github.com/timinc-cobble/cobblemon-granular-shinies/issues) or on [Discord](https://discord.com/invite/WKAR27SdSv).

## Support

If you enjoy the mod, you can [support its development on Ko-fi](https://ko-fi.com/timsminecraftmods).
