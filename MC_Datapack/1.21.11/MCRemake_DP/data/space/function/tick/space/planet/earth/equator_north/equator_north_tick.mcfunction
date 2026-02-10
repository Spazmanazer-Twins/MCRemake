# NORTH
execute at @s[x=29999983, dx=-29999983, z=-29999984, dz=-29999984] run function space:tick/space/planet/earth/equator_north/north/north_positive_tick
execute at @s[x=-29999983, dx=29999983, z=-29999984, dz=-29999984] run function space:tick/space/planet/earth/equator_north/north/north_negative_tick

# SOUTH
execute at @s[x=29999983, dx=-29999983, z=29999983, dz=29999983] run function space:tick/space/planet/earth/equator_north/south/south_positive_tick
execute at @s[x=-29999984, dx=29999983, z=29999983, dz=29999983] run function space:tick/space/planet/earth/equator_north/south/south_negative_tick

# EAST
execute at @s[x=29999983, dx=29999983, z=29999983, dz=-29999983] run function space:tick/space/planet/earth/equator_north/east/east_positive_tick
execute at @s[x=29999983, dx=29999983, z=-29999983, dz=29999983] run function space:tick/space/planet/earth/equator_north/east/east_negative_tick

# WEST
execute at @s[x=-29999984, dx=-29999984, z=29999983, dz=-29999983] run function space:tick/space/planet/earth/equator_north/west/west_positive_tick
execute at @s[x=-29999984, dx=-29999984, z=-29999983, dz=29999983] run function space:tick/space/planet/earth/equator_north/west/west_negative_tick