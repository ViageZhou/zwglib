plugins {
    `kotlin-dsl`
}
gradlePlugin {
    // 注册插件
    plugins.register("versionPlugin") {
        id = "version-plugin"
        implementationClass = "com.zwg.version.VersionPlugin"
    }
}
