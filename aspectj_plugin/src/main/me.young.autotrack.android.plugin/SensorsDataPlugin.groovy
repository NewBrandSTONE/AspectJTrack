package me.young.autotrack.android.plugin

import org.aspectj.bridge.IMessage
import org.aspectj.bridge.MessageHandler
import org.aspectj.tools.ajc.Main
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.compile.JavaCompile

public class SensorDataPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        final def log = project.logger

        project.dependencies {
            implementaion 'org.aspectj:aspectjrt:1.9.0'
        }

        project.android.applicationVariants.all { variant ->
            JavaCompile javaCompile = variant.javaComplie
            javaCompile.doLast {
                String[] args = ["-showWeaveInfo",
                                 "-1.5",
                                 "-inpath", javaCompile.destinationDir.toString(),
                                 "-aspectpath", javaCompile.classpath.asPath,
                                 "-d", javaCompile.destinationDir.toString(),
                                 "-classpath", javaCompile.classpath.asPath,
                                 "-bootclasspath", project.android.bootClasspath.join(File.pathSeparator)
                ]
                log.debug "ajc args: " + Arrays.toString(args)

                MessageHandler handler = new MessageHandler(true)
                new Main().run(args, handler)

                println()
                println("###  young 编译插件  ####")
                println()

                for (IMessage message : handler.getMessages(null, true)) {
                    switch (message.getKind()) {
                        case IMessage.ABORT:
                        case IMessage.ERROR:
                        case IMessage.FAIL:
                            log.error message.message, message.thrown
                            break
                        case IMessage.WARNING:
                            break
                        case IMessage.INFO:
                            break
                        case IMessage.DEBUG:
                            break
                    }
                }
            }
        }
    }
}