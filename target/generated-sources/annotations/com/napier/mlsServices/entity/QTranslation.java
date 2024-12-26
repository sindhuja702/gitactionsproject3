package com.napier.mlsServices.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTranslation is a Querydsl query type for Translation
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTranslation extends EntityPathBase<Translation> {

    private static final long serialVersionUID = 877660810L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTranslation translation = new QTranslation("translation");

    public final StringPath labelKey = createString("labelKey");

    public final QLanguage language;

    public final QScreen screen;

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public final StringPath translatedValue = createString("translatedValue");

    public final NumberPath<Integer> translationId = createNumber("translationId", Integer.class);

    public QTranslation(String variable) {
        this(Translation.class, forVariable(variable), INITS);
    }

    public QTranslation(Path<? extends Translation> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTranslation(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTranslation(PathMetadata metadata, PathInits inits) {
        this(Translation.class, metadata, inits);
    }

    public QTranslation(Class<? extends Translation> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.language = inits.isInitialized("language") ? new QLanguage(forProperty("language")) : null;
        this.screen = inits.isInitialized("screen") ? new QScreen(forProperty("screen")) : null;
    }

}

