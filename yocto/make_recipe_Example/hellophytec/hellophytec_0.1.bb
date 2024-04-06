ESCRIPTION = "Simple application Library"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://libsrc/add.c \
           file://libsrc/sub.c \
           file://appsrc/sample_app.c \
           file://appsrc/sample_app.h \
           file://Makefile"

S = "${WORKDIR}"
TARGET_CC_ARCH += "${LDFLAGS}"


LDFLAGS_append = " -Wl,--hash-style=gnu"
INSANE_SKIP_${PN} = "ldflags"
INHIBIT_PACKAGE_STRIP = "1"
INHIBIT_SYSROOT_STRIP = "1"
INSANE_SKIP_${PN} = "file-rdeps"
SOLIBS = ".so"
FILES_SOLIBSDEV = ""

do_compile() {
        make
}

do_install() {
        install -d ${D}/usr/bin/
        install -d ${D}/usr/lib/
        install -m 0755 ${S}/build/bin/sample_app ${D}/usr/bin/
        install -m 0755 ${S}/build/lib/libsample.so ${D}/usr/lib/
}


