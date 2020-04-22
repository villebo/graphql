package com.zcw.config;

import com.google.common.collect.Lists;
import com.google.common.io.Resources;
import com.zcw.provider.BookProvider;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

/**
 * @author : ville
 * @version : 1.0.0
 * @description : graphql配置
 * @createTime : 2020/4/22-7:39 下午
 * @copyright : ville
 * @modify : ville
 **/
@Configuration
@Slf4j
public class GraphQLConfig {
    @Autowired
    private BookProvider bookProvider;

    @Bean
    public GraphQL graphQL() {
        return GraphQL.newGraphQL(graphQLSchema()).build();
    }

    @PostConstruct
    @SneakyThrows
    public GraphQLSchema graphQLSchema() {
        SchemaGenerator schemaGenerator = new SchemaGenerator();
        //合并schema文件路径
        List<String> pathList = Lists.newArrayList();
        pathList.add("static/schema/root.graphql");
        pathList.add("static/schema/schema-enum.graphql");
        pathList.add(bookProvider.schema_path);
        //pathList.add(userProvider.schema_path);
        var registry = typeDefinitionRegistry(pathList);
        return schemaGenerator.makeExecutableSchema(registry, runtimeWiring());
    }

    @Bean
    public RuntimeWiring runtimeWiring() {
        return RuntimeWiring.newRuntimeWiring()
                //.type(userProvider.buildQueryRuntimeWiring())
                .type(bookProvider.buildQueryRuntimeWiring())
                .type(bookProvider.buildMutationRuntimeWiring())
                .type(bookProvider.buildBookRuntimeWiring())
                .build();
    }


    //schema 类型注册 主要是用来整合各个schema文件路径
    public TypeDefinitionRegistry typeDefinitionRegistry(List<String> pathList) throws IOException {
        SchemaParser schemaParser = new SchemaParser();
        TypeDefinitionRegistry typeRegistry = new TypeDefinitionRegistry();
        for (String schema_path : pathList) {
            URL url = Resources.getResource(schema_path);
            String sdl = Resources.toString(url, Charset.defaultCharset());
            typeRegistry.merge(schemaParser.parse(sdl));
        }
        return typeRegistry;
    }

}
