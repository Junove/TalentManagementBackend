# TalentManagementBackend

#!/bin/bash
git clone https://github.com/Junove/TalentManagementBackend.git

cd TalentManagementBackend/

gradle -stop

gradle wrapper

gradle build

./gradlew bootRun &

cd ..

git clone https://github.com/Junove/TalentManagementFrontend.git

cd TalentManagementFrontend/

npm install

npm run start

