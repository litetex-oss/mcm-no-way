<!-- modrinth_exclude.start -->

[![Version](https://img.shields.io/modrinth/v/no-way)](https://modrinth.com/mod/no-way)
[![Build](https://img.shields.io/github/actions/workflow/status/litetex-oss/mcm-no-way/check-build.yml?branch=dev)](https://github.com/litetex-oss/mcm-no-way/actions/workflows/check-build.yml?query=branch%3Adev)

# No Waypoints/Locator Bar

<!-- modrinth_exclude.end -->

A minimalistic mod that disables Waypoints/Locator Bar.

## Features

When installed on the server-side:
* Completely deactivates all waypoint/Locator Bar functionality
  * No waypoint or players will be tracked
  * Gamerule ``locatorBar`` will have no effect

Additionally when installed on the client-side:
* Provides a keybind to "Always hide the locator bar"
  * Default key: ``F10``
  * "Always hidden" is the default

## Why?

The whole Locator Bar feature is IMHO not mature and was rushed:
* Even when Gamerule ``locatorBar`` is set to ``false`` the server will still track and calculate the movement of players and entities.<br/>This is not necessary and causes a performance impact.
  * The whole calculation could be done on the client-side without causing additional server load
* No one explicitly asked for this feature (AFAIK), yet it was implemented, enabled by default and declared as ready for production within 14 days
* There are already name tags that solve the "Where are you???" problem... for over a decade
* The bar might be useless in certain situations, yet there is no way to disable it on the client
* The default player tracking range is basically unlimited (60 Mio blocks).<br/>
Nobody likely cares what a player 10k blocks away is doing yet it's still displayed on their bar.
* Imagine you are on a server with 5 people. Now you and a friend go exploring, however both of you somehow end up more than 280 blocks away from each other. As all Locator Bar indicators have the same size when more than 280 blocks away it now might become impossible to distinguish your friend from the other players.

<!-- modrinth_exclude.start -->

## Installation
[Installation guide for the latest release](https://github.com/litetex-oss/mcm-no-way/releases/latest#Installation)

### Usage in other mods

Add the following to ``build.gradle``:
```groovy
dependencies {
    modImplementation 'net.litetex.mcm:no-way:<version>'
    // Further documentation: https://wiki.fabricmc.net/documentation:fabric_loom
}
```

> [!NOTE]
> The contents are hosted on [Maven Central](https://repo.maven.apache.org/maven2/net/litetex/mcm/). You shouldn't have to change anything as this is the default maven repo.<br/>
> If this somehow shouldn't work you can also try [Modrinth Maven](https://support.modrinth.com/en/articles/8801191-modrinth-maven).

## Contributing
See the [contributing guide](./CONTRIBUTING.md) for detailed instructions on how to get started with our project.

<!-- modrinth_exclude.end -->
