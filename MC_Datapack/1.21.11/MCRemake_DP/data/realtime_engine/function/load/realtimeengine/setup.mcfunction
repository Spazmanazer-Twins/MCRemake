gamerule advance_time false





scoreboard objectives add RealTimeEngine dummy {"translate":"time.rte.real_time_engine","color":"yellow"}

scoreboard players display name Work_Status RealTimeEngine {"translate":"time.rte.work_status"}
scoreboard players display name Minecraft_Tick RealTimeEngine {"translate":"time.rte.minecraft_tick"}
scoreboard players display name RealTime_Tick RealTimeEngine {"translate":"time.rte.realtime_tick"}

scoreboard players display numberformat Work_Status RealTimeEngine styled {"color":"gold"}
scoreboard players display numberformat Minecraft_Tick RealTimeEngine styled {"color":"gold"}
scoreboard players display numberformat RealTime_Tick RealTimeEngine styled {"color":"gold"}





scoreboard objectives add Time dummy {"translate":"time.rte.time","color":"aqua"}

scoreboard players display name Second Time {"translate":"time.rte.second"}
scoreboard players display name Minute Time {"translate":"time.rte.minute"}
scoreboard players display name Hour Time {"translate":"time.rte.hour"}
scoreboard players display name Day Time {"translate":"time.rte.day"}
scoreboard players display name Year Time {"translate":"time.rte.year"}
scoreboard players display name Сentury Time {"translate":"time.rte.century"}
scoreboard players display name Millennium Time {"translate":"time.rte.millennium"}

scoreboard players display numberformat Second Time styled {"color":"gold"}
scoreboard players display numberformat Minute Time styled {"color":"gold"}
scoreboard players display numberformat Hour Time styled {"color":"gold"}
scoreboard players display numberformat Day Time styled {"color":"gold"}
scoreboard players display numberformat Year Time styled {"color":"gold"}
scoreboard players display numberformat Сentury Time styled {"color":"gold"}
scoreboard players display numberformat Millennium Time styled {"color":"gold"}


scoreboard objectives add Setup_Time trigger {"translate":"time.rte.setup_time","color":"red"}


execute unless score Work_Status RealTimeEngine matches 1 run scoreboard players add Work_Status RealTimeEngine 1
execute if score Work_Status RealTimeEngine matches 1 run time set 18000