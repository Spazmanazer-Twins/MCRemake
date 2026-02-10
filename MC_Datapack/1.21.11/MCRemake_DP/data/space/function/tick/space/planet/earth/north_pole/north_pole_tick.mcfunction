# NORTH
execute at @s[x=29999983, dx=-29999983, z=-29999984, dz=-29999984] in space:earth_equator_south run function space:tick/space/planet/earth/north_pole/north/north_positive_tick
execute at @s[x=-29999983, dx=29999983, z=-29999984, dz=-29999984] in space:earth_equator_south run function space:tick/space/planet/earth/north_pole/north/north_negative_tick

# SOUTH
execute at @s[x=29999983, dx=-29999983, z=29999983, dz=29999983] in space:earth_equator_north run function space:tick/space/planet/earth/north_pole/south/south_positive_tick
execute at @s[x=-29999984, dx=29999983, z=29999983, dz=29999983] in space:earth_equator_north run function space:tick/space/planet/earth/north_pole/south/south_negative_tick

# EAST
execute at @s[x=29999983, dx=29999983, z=29999983, dz=-29999983] in space:earth_equator_east run function space:tick/space/planet/earth/north_pole/east/east_positive_tick
execute at @s[x=29999983, dx=29999983, z=-29999983, dz=29999983] in space:earth_equator_east run function space:tick/space/planet/earth/north_pole/east/east_negative_tick

# WEST
execute at @s[x=-29999984, dx=-29999984, z=29999983, dz=-29999983] run function space:tick/space/planet/earth/north_pole/west/west_positive_tick
execute at @s[x=-29999984, dx=-29999984, z=-29999983, dz=29999983] run function space:tick/space/planet/earth/north_pole/west/west_negative_tick