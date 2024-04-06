all: sample_app libsample.so

sample_app: appsrc/sample_app.c libsample.so
	@${CC} appsrc/sample_app.c -Lbuild/lib -lsample -o build/bin/sample_app


libsample.so: add.o sub.o
	@${CC} -shared -o build/lib/libsample.so libsrc/add.o libsrc/sub.o appsrc/sample_app.h

add.o sub.o: libsrc/add.c libsrc/sub.c
	@mkdir -p build/bin
	@mkdir -p build/lib
	@${CC} -c libsrc/add.c -o libsrc/add.o -fPIC
	@${CC} -c libsrc/sub.c -o libsrc/sub.o -fPIC

clean:
	@rm -rf build
	@rm -rf libsrc/*.o



