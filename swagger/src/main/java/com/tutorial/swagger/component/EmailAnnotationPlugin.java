package com.tutorial.swagger.component;

import com.google.common.base.Optional;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import springfox.bean.validators.plugins.Validators;
import springfox.documentation.builders.ModelPropertyBuilder;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.schema.ModelPropertyBuilderPlugin;
import springfox.documentation.spi.schema.contexts.ModelPropertyContext;

import javax.validation.constraints.Email;

@Component
@Order(Validators.BEAN_VALIDATOR_PLUGIN_ORDER)
public class EmailAnnotationPlugin implements ModelPropertyBuilderPlugin {

    @Override
    public void apply(ModelPropertyContext context) {
        Optional<Email> email = Validators.annotationFromBean(context, Email.class);
        if (email.isPresent()) {
            context.getBuilder().pattern(email.get().regexp());
            context.getBuilder().example("email@email.com");
        }
    }

    @Override
    public boolean supports(DocumentationType delimiter) {
        return true;
    }
}
