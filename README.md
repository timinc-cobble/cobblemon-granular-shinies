# Cobblemon Granular Shinies

v1.8.1-1.1

[Modrinth](https://modrinth.com/mod/cobblemon-granularshinies)

[CurseForge](https://www.curseforge.com/minecraft/mc-mods/cobblemon-granularshinies)

[GitHub](https://github.com/timinc-cobble/cobblemon-granular-shinies)

## What if…

…you could control the shiny rate of Pokémon on a more granular level?

## Features

- Set custom shiny odds for Pokémon matching a Pokémon Properties description.
- Configure different odds for individual species, forms, and other supported properties.
- Run the mod on the server without requiring players to install it.
- Reload configuration changes without restarting the server.

## Configuration

Shiny overrides are defined as Pokémon Properties strings paired with the desired
shiny-chance denominator. The first matching override is used. For example:

```json
{
  "debug": false,
  "overrides": {
    "moltres": 20.0,
    "ponyta galarian": 100.0
  }
}
```

This gives Moltres a 1-in-20 shiny chance and Galarian Ponyta a 1-in-100 shiny
chance.

## Dependencies

- [Cobblemon](https://modrinth.com/mod/cobblemon)
- [Tim Core](https://modrinth.com/mod/cobblemon-tim-core)

## Feedback

If you have questions or requests, or just want to drop by and say hi, visit us
on [Discord](https://discord.com/invite/WKAR27SdSv).

## Support

If I've made something you enjoyed or helped you make something, please consider
[dropping a tip in the cup](https://ko-fi.com/timsminecraftmods) and mention how
I helped if you'd like!
