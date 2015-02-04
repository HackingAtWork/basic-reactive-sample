cd commonmodule
sbt package
cp target/*/common_*-SNAPSHOT.jar ../factory-union/lib
cp target/*/common_*-SNAPSHOT.jar ../factory-workers/lib
cp target/*/common_*-SNAPSHOT.jar ../machines/lib
cp target/*/common_*-SNAPSHOT.jar ../overlord/lib
cd ..

