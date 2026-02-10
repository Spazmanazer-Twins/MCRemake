execute store result storage space:planet.earth.teleport.equator_north x int 1 run data get entity @s Pos.[0] 1
execute store result storage space:planet.earth.teleport.equator_north y int 1 run data get entity @s Pos.[1] 1
execute store result storage space:planet.earth.teleport.equator_north z int 1 run data get entity @s Pos.[2] -1
function space:tick/space/planet/earth/equator_east/north/north_teleport with storage space:planet.earth.teleport.equator_north