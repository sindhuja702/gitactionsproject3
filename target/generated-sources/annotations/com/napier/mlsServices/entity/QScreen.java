package com.napier.mlsServices.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QScreen is a Querydsl query type for Screen
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QScreen extends EntityPathBase<Screen> {

    private static final long serialVersionUID = 1673815283L;

    public static final QScreen screen = new QScreen("screen");

    public final StringPath featureName = createString("featureName");

    public final StringPath moduleName = createString("moduleName");

    public final NumberPath<Integer> screenId = createNumber("screenId", Integer.class);

    public final StringPath screenName = createString("screenName");

    public final StringPath serviceName = createString("serviceName");

    public final ListPath<Translation, QTranslation> translation = this.<Translation, QTranslation>createList("translation", Translation.class, QTranslation.class, PathInits.DIRECT2);

    public QScreen(String variable) {
        super(Screen.class, forVariable(variable));
    }

    public QScreen(Path<? extends Screen> path) {
        super(path.getType(), path.getMetadata());
    }

    public QScreen(PathMetadata metadata) {
        super(Screen.class, metadata);
    }

}

