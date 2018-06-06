package com.annotation;

import com.sun.source.util.Trees;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;


/**
 * Elements：一个用来处理Element的工具类
 Types：一个用来处理TypeMirror的工具类
 Filer：你可以使用这个类来创建.java文件
 */
//@AutoService(Processor.class)
public class BindProcessor extends AbstractProcessor {

    /***
     * //用来指定你使用的 java 版本。通常你应该返回
     * @return
     */
    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    private Filer mFiler; //文件相关的辅助类
    private Elements mElementUtils; //元素相关的辅助类
    private Messager mMessager; //日志相关的辅助类

    private Types mTypeUtils;
    private Trees trees;

    /**
     * 会被处理器调用，可以在这里获取Filer，Elements，Messager等辅助类，后面会解释
     * @param processingEnv
     */
    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        mElementUtils = processingEnv.getElementUtils();
        mTypeUtils = processingEnv.getTypeUtils();
        mFiler = processingEnv.getFiler();
        try {
            trees = Trees.instance(processingEnv);
        } catch (IllegalArgumentException ignored) {
        }
    }

    /**
     * 这个方法返回stirng类型的set集合，集合里包含了你需要处理的注解
     * @return
     */
    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> annotataions = new LinkedHashSet<>();
        annotataions.add("com.annotation.BindView");
        return annotataions;
    }

    /**
     * 核心方法，这个一般的流程就是先扫描查找注解，再生成 java 文件
     * 这2个步骤设计的知识点细节很多。
     * @param annotations
     * @param roundEnv
     * @return
     */
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        //1.查找所有的注解信息，并形成BindingClass（是什么 后面会讲） 保存到 map中
        //2.遍历步骤1的map 的生成.java文件也就是上文的  类名_ViewBinding  的java文件
        return true;
    }
}
