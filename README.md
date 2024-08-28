# TalentManagementBackend

#!/bin/bash

git clone https://github.com/Junove/TalentManagementBackend.git

cd TalentManagementBackend/

gradle -stop

gradle wrapper

gradle build

./gradlew bootRun &

cd ..

sleep 30

git clone https://github.com/Junove/TalentManagementFrontend.git

cd TalentManagementFrontend/

npm install --force

npm run start

#MAKE SURE TO RUN gradle -stop ON THE TERMINAL AFTER YOU'RE DONE!
