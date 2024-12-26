package com.napier.mlsServices.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLanguage is a Querydsl query type for Language
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLanguage extends EntityPathBase<Language> {

    private static final long serialVersionUID = 1016738335L;

    public static final QLanguage language = new QLanguage("language");

    public final StringPath languageDescription = createString("languageDescription");

    public final NumberPath<Integer> languageId = createNumber("languageId", Integer.class);

    public final StringPath languageName = createString("languageName");

    public final ListPath<Translation, QTranslation> translation = this.<Translation, QTranslation>createList("translation", Translation.class, QTranslation.class, PathInits.DIRECT2);

    public QLanguage(String variable) {
        super(Language.class, forVariable(variable));
    }

    public QLanguage(Path<? extends Language> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLanguage(PathMetadata metadata) {
        super(Language.class, metadata);
    }

}

