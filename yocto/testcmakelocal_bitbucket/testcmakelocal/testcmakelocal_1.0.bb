
DESCRIPTION = "Simple application Library"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"


#Fetch the sources from bitbucket 
SRC_URI = "git://bitbucket.org/ridebuddy-bosch/ridebuddy_bsample_linux.git;protocol=https;branch=test;user=${BITBUCKET_USERNAME}:${BITBUCKET_TOKEN}"

#Just as an example of SRC_URI which fetch from bitbucket where BITBUCKET_USERNAME & BITBUCKET_TOKEN should be defined in build/conf/local.conf
#If we build recipe, it will throw error of CMakeLists.txt file since our repo doesn't have any, it has simple txt file----THis is for demo purpose only
#Fetch the source everytime from github since changes should be updated here, but while fetch from tag/release AUTOREV not be used
SRCREV = "${AUTOREV}"
#Point the source directory to git since we fetch sources from git. If we use git, git folder will be created automatically
S = "${WORKDIR}/git"

TARGET_CC_ARCH += "${LDFLAGS}"

LDFLAGS_append = " -Wl,--hash-style=gnu"
INSANE_SKIP_${PN} = "ldflags"
INHIBIT_PACKAGE_STRIP = "1"
INHIBIT_SYSROOT_STRIP = "1"
INSANE_SKIP_${PN} = "file-rdeps"
SOLIBS = ".so"
FILES_SOLIBSDEV = ""

inherit cmake
#Ensure CMakeLists.txt file should be in ${S} folder since by default OECMAKE will point to ${S}

do_install() {
        install -d ${D}/usr/bin/
        install -d ${D}/usr/lib/
        install -m 0755 ${WORKDIR}/build/bin/sample_app ${D}/usr/bin/
        install -m 0755 ${WORKDIR}/build/lib/libsample.so ${D}/usr/lib/
}
