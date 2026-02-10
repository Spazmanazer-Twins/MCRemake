scoreboard players add Minecraft_Tick RealTimeEngine 1
scoreboard players add RealTime_Tick RealTimeEngine 1

execute if score Minecraft_Tick RealTimeEngine matches 19 run scoreboard players add Second Time 1
execute if score Minecraft_Tick RealTimeEngine matches 19 run scoreboard players set Minecraft_Tick RealTimeEngine 0

execute if score Second Time matches 60 run scoreboard players add Minute Time 1
execute if score Second Time matches 60 run scoreboard players set Second Time 0

execute if score Minute Time matches 60 run scoreboard players add Hour Time 1
execute if score Minute Time matches 60 run scoreboard players set Minute Time 0

execute if score Hour Time matches 23 run scoreboard players add Day Time 1
execute if score Hour Time matches 23 run scoreboard players set Hour Time 0

execute if score Day Time matches 364 run scoreboard players add Year Time 1
execute if score Day Time matches 364 run scoreboard players set Day Time 0

execute if score Year Time matches 100 run scoreboard players add Сentury Time 1
execute if score Year Time matches 100 run scoreboard players set Year Time 0

execute if score Сentury Time matches 1000 run scoreboard players add Millennium Time 1
execute if score Сentury Time matches 100 run scoreboard players set Сentury Time 0

execute if score RealTime_Tick RealTimeEngine matches 71 run time add 1
execute if score RealTime_Tick RealTimeEngine matches 71 run scoreboard players set RealTime_Tick RealTimeEngine 0