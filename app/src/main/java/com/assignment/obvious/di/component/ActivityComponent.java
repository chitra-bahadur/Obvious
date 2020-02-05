package com.assignment.obvious.di.component;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

import dagger.Component;

@Component(dependencies = ApplicationComponent.class)
public interface ActivityComponent {
}
