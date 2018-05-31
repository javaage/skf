package com.skf.management.common;

//@Documented
//@Target(ElementType.METHOD)
//@Retention(RetentionPolicy.RUNTIME)
public @interface Permission {

	AnnotationEnum value() default AnnotationEnum.USER;

	public static enum AnnotationEnum {
		ADMIN, USER
	}

}
