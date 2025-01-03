<h1>Spruce Willis the Xmas Tree</h1>
<h5>Bruce has evolved into Spruce Willis the Christmas Tree!</h5>

<a href="https://discord.tophatcat.dev">
    <img src="https://img.shields.io/badge/Discord-CattusMods-brightgreen.svg?style=flat&logo=Discord" alt="Discord server invite."/>
</a>

<a href="https://modrinth.com/mod/spruce-willis-the-xmas-tree">
    <img src="https://img.shields.io/modrinth/dt/E4DbrlAA?style=flat&label=Modrinth&logo=modrinth" alt="Modrinth Badge.">
</a>

<a href="https://www.curseforge.com/minecraft/mc-mods/spruce-willis-the-xmas-tree">
    <img src="https://img.shields.io/curseforge/dt/354046?style=flat&label=CurseForge&logo=curseforge" alt="CurseForge Badge.">
</a>

<a href="https://github.com/kiris-mods/spruce-willis-the-xmas-tree/actions/workflows/build_status.yml">
    <img src="https://img.shields.io/github/actions/workflow/status/kiris-mods/spruce-willis-the-xmas-tree/build_status.yml?branch=dev&style=flat&label=Build Status&logo=github" alt="Github Build Status.">
</a>

<a href="https://tophatcat.dev/">
    <img src="https://img.shields.io/badge/Website-tophatcat.dev-brightgreen.svg?style=flat" alt="Website link."/>
</a>

<a href="https://github.com/kiris-mods/spruce-willis-the-xmas-tree/commits/dev">
    <img src="https://img.shields.io/github/last-commit/kiris-mods/spruce-willis-the-xmas-tree.svg" alt="Latest commit.">
</a>

### Custom gradle tasks
This workspace has a custom gradle task called ``cleanCode``, this task adds license headers, formats the code and compiles a code standards report that can be found per subproject, example: ``neoforge/reports/main.html``  
Should you wish to do any of these on their own you can run any of the following:
- ``./gradlew licenseFormat`` Adds the license header to any classes without them.
- ``./gradlew spotlessApply`` Formats the code according to our code format rules.
- ``./gradlew pmdMain`` Compiles a code standards report you can use to improve your code.    
