#!/bin/sh
java -jar /opt/tides/OpenTides.jar -Xms512M -Xmx1384M -Dfile.encoding="UTF-8" -Duser.timezone=UTC -Dspring.profiles.active=prod --spring.profiles.active=prod
