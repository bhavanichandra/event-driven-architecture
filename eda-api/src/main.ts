import { NestFactory } from '@nestjs/core';
import { AppModule } from './app.module';
import { SwaggerModule, DocumentBuilder } from '@nestjs/swagger';

async function bootstrap() {
  const app = await NestFactory.create(AppModule);
  const config = new DocumentBuilder()
    .setTitle('To Do App')
    .setDescription(
      'Simple ToDo app to test Event Driven Architecture in NestJS'
    )
    .setVersion('1.0')
    .setLicense('MIT', 'https://opensource.org/licenses/MIT')
    .build();
  const swagger = SwaggerModule.createDocument(app, config);
  SwaggerModule.setup('api', app, swagger);
  await app.listen(8080);
}
bootstrap();
