package tictactoe.di;

import tictactoe.datasource.repository.GameRepository;
import tictactoe.datasource.repository.impl.GameRepositoryImpl;
import tictactoe.datasource.storage.GameStorage;
import tictactoe.datasource.mapper.DataSourceMapper;
import tictactoe.domain.service.GameService;
import tictactoe.domain.service.impl.GameServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public GameStorage gameStorage() {
        return new GameStorage();
    }

    @Bean
    public DataSourceMapper dataSourceMapper() {
        return new DataSourceMapper();
    }

    @Bean
    public GameRepository gameRepository(GameStorage gameStorage, DataSourceMapper dataSourceMapper) {
        return new GameRepositoryImpl(gameStorage, dataSourceMapper);
    }

    @Bean
    public GameService gameService(GameRepository gameRepository) {
        return new GameServiceImpl(gameRepository);
    }
}